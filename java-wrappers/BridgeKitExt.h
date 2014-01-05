//
//  BridgeKitExt.h
//  BridgeKitExt
//
//  Created by Andrei Bakulin
//

#import <BridgeKit/JavaObject.h>
#import <BridgeKit/AndroidActivity.h>

@interface BridgeKitExt : JavaObject

- (id)initWithString:(NSString*)str;

- (NSString*)getDeviceIMEI:(AndroidActivity*)activity;

- (void)createView:(AndroidActivity*)activity;
- (void)createPopupWindow:(AndroidActivity*)activity;

@end
