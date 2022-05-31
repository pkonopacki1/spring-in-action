package com.konopackipio1.tacocloud.data;

import com.konopackipio1.tacocloud.model.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder tacoOrder);

}
