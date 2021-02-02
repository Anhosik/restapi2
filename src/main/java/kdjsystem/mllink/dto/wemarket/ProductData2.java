package kdjsystem.mllink.dto.wemarket;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Data
public class ProductData2 {
    private String resultCode;
    private WeMarketProductReg data;
    private String error;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class WeMarketProductReg {
        private String productNo;
        private String partnerGroupId;
//        private Basic basic;
    }

//    @Getter
//    @Setter
//    @AllArgsConstructor
//    @NoArgsConstructor
//    @Builder
//    private static class Basic {
//        private String productName;
//
//
//
//    }
}
