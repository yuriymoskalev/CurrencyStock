package ru.wootography.cryptotest.interfaces.views;

import ru.wootography.cryptotest.interfaces.utils_view.NavigatorActivityView;

public interface SplashView extends BaseView, NavigatorActivityView {
    void showErrorConnection(boolean show);
}
