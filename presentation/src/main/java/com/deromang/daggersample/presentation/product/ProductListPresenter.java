package com.deromang.daggersample.presentation.product;

import com.deromang.daggersample.domain.data.Photo;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public interface ProductListPresenter {

    void setView(ProductListView view);

    void goToDetails(Photo photo);

    void requestData();

    void onTextChanged(CharSequence value);
}
