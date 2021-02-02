package kdjsystem.mllink.dto.wemarket;

import lombok.*;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductList {
    private String resultCode;
    private List<ResultData> data;
    private String error;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ResultData {
        private String productNo;
    }

}