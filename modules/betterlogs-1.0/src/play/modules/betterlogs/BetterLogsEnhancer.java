/*
 * Copyright 2011 Stephane Godbillon
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package play.modules.betterlogs;

import javassist.CannotCompileException;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;
import play.classloading.ApplicationClasses.ApplicationClass;
import play.classloading.enhancers.Enhancer;

public class BetterLogsEnhancer extends Enhancer {
	@Override
	public void enhanceThisClass(final ApplicationClass applicationClass) throws Exception {
		final CtClass ctClass = makeClass(applicationClass);
		for(final CtBehavior behavior : ctClass.getDeclaredBehaviors()) {
			behavior.instrument(new ExprEditor() {
				@Override
				public void edit(MethodCall m) throws CannotCompileException {
					try {
						if("play.Logger".equals(m.getClassName())) {
							String name = m.getMethodName();
							//String level, String clazz, String clazzSimpleName, String packageName, String method, String signature, String fileName, String relativeFileName, int line, Object[] args
							if("trace".equals(name) || "debug".equals(name) || "info".equals(name) || "warn".equals(name) || "error".equals(name) || "fatal".equals(name)) {
								String code = String.format("{play.modules.betterlogs.BetterLogsPlugin.log(\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", %s, %s);}",
										name,
										ctClass.getName(), // canonical name
										ctClass.getSimpleName(), // simple name
										ctClass.getPackageName(), // package
										behavior.getName(),
										behavior.getSignature(),
										m.getFileName(),
										applicationClass.javaFile.relativePath(),
										m.getLineNumber(),
										"$args" // original args
								);
								m.replace(code);
							}
						}
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
			});
		}
		applicationClass.enhancedByteCode = ctClass.toBytecode();
		ctClass.defrost();
	}
}
