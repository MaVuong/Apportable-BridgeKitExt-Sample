//
//  BridgeKitExt.m
//  BridgeKitExt
//
//  Created by Andrei Bakulin
//

#import "BridgeKitExt.h"

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wobjc-property-implementation"
#pragma clang diagnostic ignored "-Wincomplete-implementation"
@implementation BridgeKitExt

+ (void)initializeJava
{
    [super initializeJava];

    [BridgeKitExt registerConstructorWithSelector:@selector(initWithString:)
                                        arguments:[NSString className], nil];
    
    [BridgeKitExt registerInstanceMethod:@"getDeviceIMEI"
                                selector:@selector(getDeviceIMEI:)
                             returnValue:[NSString className]
                               arguments:@"android/app/Activity", nil];
    
    [BridgeKitExt registerInstanceMethod:@"createView"
                                selector:@selector(createView:)
                               arguments:@"android/app/Activity", nil];

    [BridgeKitExt registerInstanceMethod:@"createPopupWindow"
                                selector:@selector(createPopupWindow:)
                               arguments:@"android/app/Activity", nil];
}

+ (NSString *)className
{
    return @"com.duksel.apportable.BridgeKitExt";
}

@end
#pragma clang diagnostic pop
