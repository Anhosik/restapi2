package kdjsystem.mllink.dto.wemarket;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductData {
    private String resultCode;
    private Data data;
    private String error;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Data {
        private Integer totalCount;
        private List<WemarketList> list;


    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class WemarketList {
        private String saleEndDate;
        private Number salePrice;
        private String displayYnName;
        private String saleStatusName;
        private Integer makerNo;
        private String lcateName;
        private String mcateName;
        private Integer brandNo;
        private String saleStartDate;
        private String productStatusName;
        private String scateName;
        private String makerName;
        private Integer shipPolicyNo;
        private Integer productNo;
        private String registerDate;
        private String brandName;
        private String mallTypeName;
        private String productName;
        private String dcateName;
        private String changeDate;

    }

}
