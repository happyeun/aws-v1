package com.metacoding.v1.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloController {


    @GetMapping("/aws/v1")
    public String hello(@RequestParam(defaultValue = "1") Integer number){
        /*
        * 로그의 3가지 경우가 찍힘
        *   엔드포인트 주소 "/aws/v1" 뒤의 parameter "number"의 값을 "1,-1,0" 에 따라서
        *   info, error, warn 종류가 찍힘.
        * */


        // 내가 작성한 코드 :  내가 파리미터 별로 HTML 태그 출력값을 다르게 해놓았음.
        String returnString="<h1>aws v1</h1></br><h3>defaultValue parameter=1, info 로그가 찍힐 겁니다.</h3>";
        if(number == 1){ // info 로그
            log.info("/aws/v1 이 호출되었어요. info 로그 #####################################");
            returnString ="<h1>aws v1</h1></br><h3>defaultValue parameter=1, info 로그가 찍힐 겁니다.</h3>";
        }else if(number == -1){ // error 로그
            log.error("/aws/v1 이 호출되었어요. error 로그 #####################################");
            returnString ="<h1>aws v1</h1></br><h3>parameter=-1, error 로그가 찍힐 겁니다.</h3>";
        }else if(number == 0){ // warn 로그
            log.warn("/aws/v1 이 호출되었어요. warn 로그 #####################################");
            returnString ="<h1>aws v1</h1></br><h3>parameter=0, warn 로그가 찍힐 겁니다.</h3>";
        }

        return returnString;

        // 강사선생님 원래 코드
        /*
            if(number == 1){ // info 로그
                log.info("/aws/v1 이 호출되었어요. info 로그 #####################################");
            }else if(number == -1){ // error 로그
                log.error("/aws/v1 이 호출되었어요. error 로그 #####################################");
            }else if(number == 0){ // warn 로그
                log.warn("/aws/v1 이 호출되었어요. warn 로그 #####################################");
            }

            return "<h1>aws v1</h1>";
         */
    }
}
