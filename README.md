# Short Url
* 업무 중 Short Url 서비스가 필요해서 여러 정보를 찾아봄
* 연습 프로젝트 진행

### Environment
* Java 17
* SpringBoot
* Jpa
* H2

### TODO
1. DB 만 사용 하는 서비스 (최대한 TDD 연습 해보기)
   * ShortUrlApiController
     * POST /short {fullUrl} 요청 시 URL 형식이 아니면 Fail Response
     * POST /short {fullUrl} 요청 시 Empty 면 Fail Response
     * POST /short {fullUrl} 요청 시 Url 형식 이고, UrlValid 실패하면 Fail Response
     * POST /short {fullUrl} 요청 시 Url 형식 이고, Urlvalid 통과하면 Success Response
     * GET /{encodedId} 요청 시 Entity 가 존재하지 않으면, Fail Response
     * GET /{encodedId} 요청 시 Entity 존재, UrlValid 실패하면 Fail Response (save 시 valid 했지만 다시 한번)
     * GET /{encodedId} 요청 시 Entity 존재, UrlValid 통과하면 fullUrl 로 redirect 시켜준다.(save 시 valid 했지만 다시 한번)
   * ShortUrlFacade
     * url save 시 DB 에 저장된 ID 를 encode 해서 Return
     * find 시 DB pathvariable 로 받은 encodedId -> decode -> db 조회해서 fullUrl
   
2. ehcache, redis Chain 구성
3. Resilience4j CircuitBreaker 사용 redis 장애시 DB 조회로 해보자

### Reference
* [PropertiesTest](https://www.baeldung.com/spring-boot-testing-configurationproperties)
* [PropertiesTest](https://github.com/HomoEfficio/dev-tips/blob/master/Spring-Boot-Unit-Test-YAML.md)
* [PropertiesTest](https://pooney.tistory.com/88)
* [configuration-properties-in-springboot](https://www.baeldung.com/configuration-properties-in-spring-boot)