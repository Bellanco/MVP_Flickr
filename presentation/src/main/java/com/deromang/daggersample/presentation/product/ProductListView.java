package com.deromang.daggersample.presentation.product;

import com.deromang.daggersample.domain.data.Photo;

import java.util.List;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public interface ProductListView {

    void notifyDataSetChanged(List<Photo> photoList);
}
