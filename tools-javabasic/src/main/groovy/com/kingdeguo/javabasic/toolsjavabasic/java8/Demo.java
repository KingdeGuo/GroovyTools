package com.kingdeguo.javabasic.toolsjavabasic.java8;

import java.util.Objects;

public class Demo {

    public static void main(String[] args) {
        SinglePassActionVO passActionVO = new SinglePassActionVO();
        passActionVO.setBindDiseaseId(null);

//        Long diseaseId = Objects.isNull(passActionVO) ? 0L : Long.valueOf(null);
//        Long diseaseId = Objects.isNull(passActionVO) ? 0L : null;
//        Long diseaseId = Objects.isNull(passActionVO) ? getValue() : passActionVO.getBindDiseaseId();
//        Long diseaseId = Objects.isNull(passActionVO) ? passActionVO.getBindDiseaseId() : 0L;

//        Long.valueOf(null);
//        System.out.println(diseaseId);

        Integer cntRes = null;
        Integer ans = Objects.nonNull(cntRes) ? cntRes : 0;
        System.out.println(ans);
    }

    static Long getValue(){
        return 2L;
    }

}
