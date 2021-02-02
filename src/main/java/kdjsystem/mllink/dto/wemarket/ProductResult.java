package kdjsystem.mllink.dto.wemarket;

import lombok.*;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResult {
    private String resultCode;
    private ResultProdData data;
    private String error;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ResultProdData {
        private String productNo;
        private String returnMsg;

    }
}