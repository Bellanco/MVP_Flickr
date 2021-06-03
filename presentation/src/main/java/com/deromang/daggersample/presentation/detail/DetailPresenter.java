package com.deromang.daggersample.presentation.detail;


/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public interface DetailPresenter {

    void goBack();

    void setView(DetailView view);

    void requestData();

    void getDetailImage(String idPhoto, String secretNumber);

    void getUrlImage(String idPhoto);

}
