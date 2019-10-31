package ru.mail.trade;

import ru.mail.trade.type.Bond;
import ru.mail.trade.type.CommoditySpot;
import ru.mail.trade.type.FxSpot;
import ru.mail.trade.type.IrSwap;

public enum TradeEnum {

    BOND {
        public Trade create(Double price) {
            return new Bond(price);
        }
    },
    COMMODITY_SPOT {
        public Trade create(Double price) {
            return new CommoditySpot(price);
        }
    },
    FX_SPOT {
        public Trade create(Double price) {
            return new FxSpot(price);
        }
    },
    IR_SWAP {
        public Trade create(Double price) {
            return new IrSwap(price);
        }
    };

    public abstract Trade create(Double price);
}
