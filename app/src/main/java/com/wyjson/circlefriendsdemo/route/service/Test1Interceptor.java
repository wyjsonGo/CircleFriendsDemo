package com.wyjson.circlefriendsdemo.route.service;

public class Test1Interceptor {

}
//@Interceptor(priority = 2, name = "朋友圈拦截器")
//public class CircleFriendsInterceptor implements IInterceptor {
//
//    @Override
//    public void process(Postcard postcard, InterceptorCallback callback) {
//        if (postcard.getPath().equals(CircleFriendsRouteHelper.CircleFriendsActivity)) {
//            CircleFriendsActivity.go(postcard.getContext());
//            callback.onInterrupt(new RuntimeException("手动进入"));
//            return;
//        }
//        callback.onContinue(postcard);
//    }
//
//    @Override
//    public void init(Context context) {
//    }
//}
