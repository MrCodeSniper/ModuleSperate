package com.stream.chenhong.moduletest;


// * ================================================
// * 此类只是简单的实现了 Glide 加载的策略,方便快速使用,但大部分情况会需要应对复杂的场景
// * 这时可自行实现 {@link BaseImageLoaderStrategy} 和 {@link ImageConfig} 替换现有策略
// *
// * @see GlobalConfigModule.Builder#imageLoaderStrategy(BaseImageLoaderStrategy)
// * ================================================
// */

public class GlideImageLoaderStrategy{



//public class GlideImageLoaderStrategy implements BaseImageLoaderStrategy<ImageConfigImpl>, GlideAppliesOptions {

//    @Override
//    public void loadImage(Context ctx, ImageConfigImpl config) {
//        Preconditions.checkNotNull(ctx, "Context is required");
//        Preconditions.checkNotNull(config, "ImageConfigImpl is required");
//        if (TextUtils.isEmpty(config.getUrl())){
//            Logger.e("Url is required");
//            return;
//        }
//        Preconditions.checkNotNull(config.getImageView(), "ImageView is required");
//
//
//        GlideRequests requests;
//
//        requests = GlideArms.with(ctx);//如果context是activity则自动使用Activity的生命周期
//
//        GlideRequest<Drawable> glideRequest = requests.load(config.getUrl());
//
//        switch (config.getCacheStrategy()) {//缓存策略
//            case 0:
//                glideRequest.diskCacheStrategy(DiskCacheStrategy.ALL);
//                break;
//            case 1:
//                glideRequest.diskCacheStrategy(DiskCacheStrategy.NONE);
//                break;
//            case 2:
//                glideRequest.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
//                break;
//            case 3:
//                glideRequest.diskCacheStrategy(DiskCacheStrategy.DATA);
//                break;
//            case 4:
//                glideRequest.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
//                break;
//            default:
//                glideRequest.diskCacheStrategy(DiskCacheStrategy.ALL);
//                break;
//        }
//
//        if (config.isCrossFade()) {
//            glideRequest.transition(DrawableTransitionOptions.withCrossFade());
//        }
//
//        if (config.isCenterCrop()) {
//            glideRequest.centerCrop();
//        }
//
//        if (config.isCircle()) {
//            glideRequest.circleCrop();
//        }
//
//        if (config.isImageRadius()) {
//            glideRequest.transform(new RoundedCorners(config.getImageRadius()));
//        }
//
//        if (config.isBlurImage()) {
//            glideRequest.transform(new BlurTransformation(config.getBlurValue()));
//        }
//
//        if (config.getTransformation() != null) {//glide用它来改变图形的形状
//            glideRequest.transform(config.getTransformation());
//        }
//
//        if (config.getPlaceholder() != 0)//设置占位符
//            glideRequest.placeholder(config.getPlaceholder());
//
//        if (config.getErrorPic() != 0)//设置错误的图片
//            glideRequest.error(config.getErrorPic());
//
//        if (config.getFallback() != 0)//设置请求 url 为空图片
//            glideRequest.fallback(config.getFallback());
//
//
//        glideRequest
//                .into(config.getImageView());
//
//
//
//
//    }
//
//    @Override
//    public void clear(final Context ctx, ImageConfigImpl config) {
//        Preconditions.checkNotNull(ctx, "Context is required");
//        Preconditions.checkNotNull(config, "ImageConfigImpl is required");
//
//        if (config.getImageViews() != null && config.getImageViews().length > 0) {//取消在执行的任务并且释放资源
//            for (ImageView imageView : config.getImageViews()) {
//                GlideArms.get(ctx).getRequestManagerRetriever().get(ctx).clear(imageView);
//            }
//        }
//
//        if (config.isClearDiskCache()) {//清除本地缓存
//            Observable.just(0)
//                    .observeOn(Schedulers.io())
//                    .subscribe(new Consumer<Integer>() {
//                        @Override
//                        public void accept(@NonNull Integer integer) throws Exception {
//                            Glide.get(ctx).clearDiskCache();
//                        }
//                    });
//        }
//
//        if (config.isClearMemory()) {//清除内存缓存
//            Observable.just(0)
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new Consumer<Integer>() {
//                        @Override
//                        public void accept(@NonNull Integer integer) throws Exception {
//                            Glide.get(ctx).clearMemory();
//                        }
//                    });
//        }
//
//    }
//
//
//    @Override
//    public void applyGlideOptions(Context context, GlideBuilder builder) {
//        Timber.w("applyGlideOptions");
//    }
}
