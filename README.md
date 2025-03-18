Build the app on Android, run it and try to reload it twice very fast to get the null JavaScript context bug.

Comment out the relevant line in `NativeReloadBugModule.java`, build the app, run it and try reloading twice very fast to get invoking the JSI method of a TurboModule with the wrong context.
