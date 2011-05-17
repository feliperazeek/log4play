# Description
This very simple module enhances the Play! Framework logs to bring some missing information such as the class name, the method name where the log has been called, its signature, the file name and the line.

# How to use it

* Clone this module in somedirectory/betterlogs
* Add this module to your application.conf
* Customize the log pattern if you want

Example:

    module.betterlogs=somedirectory/betterlogs
    # Custom prefix (this is the default one)
    betterlogs.prefix=[%relativeFile:%line] %method() ::
    # Append 2 spaces at the end of the pattern
    betterlogs.prefix.trailingSpaces=2


In your code, the following call

`Logger.info("got %s messages from %s", 2, "somebody@gmail.com");`

will give you

`12:47:05,499 INFO  ~ [/app/controllers/Application.java:10] index() ::  got 2 messages from somebody@gmail.com`

## Pattern elements

You can add the following elements to the prefix pattern :

* **%file** : the file where the log has been called (the file path relative to the play application, ex: `/app/controllers/Application.java`)
* **%relativeFile** : the file where the log has been declared (just the file name; ex: `Application.java`)
* **%line** : the line of the file where the log has been called
* **%class** : the class in which the log has been called (canonical name, ex: `controllers.Application`)
* **%simpleClass** : the class in which the log has been called (simple name, ex: `Application`)
* **%package** : the package of the class where the log has been called
* **%method** : the name of the method in which the log has been called
* **%signature** : the signature of the method in which the log has been called (ex: `(Ljava/lang/String;Lplay/Logger;I)V`)

## Options

You can disable BetterLogs with the @betterlogs.disabled@ option :

    betterlogs.disabled=true

If you enable or disable BetterLogs, do not forget to clean your app before restarting Play, to force the framework to enhance all the classes again.

## Use with log4j

This module just prepends a string matching the prefix pattern to log string. So it does not conflict with the log4j config file even if you redefine it.

# Future features

* print some action information (like http params, action name, cookies, etc.)
