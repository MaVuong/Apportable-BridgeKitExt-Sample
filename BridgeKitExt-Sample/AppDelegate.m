//
//  AppDelegate.m
//  BridgeKitExt-Sample
//
//  Created by Andrei Bakulin
//

#import "AppDelegate.h"

#ifdef ANDROID
#import "BridgeKitExt.h"
#endif

@implementation AppDelegate

- (void)dealloc
{
    [_window release];
    [super dealloc];
}

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
    self.window = [[[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]] autorelease];
    self.window.backgroundColor = [UIColor whiteColor];
    [self.window makeKeyAndVisible];

#ifdef APPORTABLE
    BridgeKitExt    *bridgeObject = [[BridgeKitExt alloc] initWithString:@"Hello Java"];
    AndroidActivity *activity     = [AndroidActivity currentActivity];
    
    NSString *result = [bridgeObject getDeviceIMEI:activity];
    
    [bridgeObject createView:activity];
    [bridgeObject createPopupWindow:activity];
#else
    NSString *result = @"Hello iOS!";
#endif
    
    [[[[UIAlertView alloc] initWithTitle:@"BridgeKitExt Demo"
                                 message:result
                                delegate:nil
                       cancelButtonTitle:@"OK"
                       otherButtonTitles:nil] autorelease] show];

    return YES;
}

@end
