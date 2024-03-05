# 섹션 1. JPA 소개

## JPA
- Java Persistence API
- 자바 진영의 ORM 기술 표준

### ORM?
- Object-relational mapping(객체 관계 매핑)
- 객체는 객체 대로 db는 db 대로 설계
- orm 프레임워크가 중간에서 매핑

![alt text](image/image.png)

> JPA는 애플리케이션과 JDBC 사이에서 동작

* **JPA는 인터페이스의 모음**

### JPA를 사용해야 하는 이유
- SQL 중심 개발에서 객체 중심 개발
- 생산성
- 유지 보수
- 패러다임의 불일치 해결
- 성능
- 데이터 접근 추상화와 벤더 독립성
- 표준

#### 생산성 - CRUD
* 저장 : jpa.persist(member)
* 조회 : Member member = jpa.find(memberId);
* 수정 : member.setName("변경할 이름")
* 삭제 : jpa.remove(member)

#### 유지보수
* 기존 : 필드 변경 시 모든 sql 수정 -> JPA : 필드 변경 시 나머지 sql은 JPA가 처리해준다.

#### 상속 가능 , 연관관계, 객체 그래프 탐색 -> 신뢰 할 수 있는 엔티티, 계층

#### 성능 최적화 기능
* 1차 캐시와 동일성(identity) 보장
  * JPA는 같은 트랜잭션 안에서는 같은 엔티티를 반환 - 약간의 조희 성능 향상
* 트랜잭션을 지원하는 쓰기 지연
  * 트랜잭션을 커밋 할 때까지 INSERT SQL을 모음
    * JDBC BATCH SQL 기능을 사용해서 한번에 SQL 전송
  * UPDATE, DELETE로 인한 로우(ROW)락 시간 최소화
    * 트랜잭션 커밋 시 UPDATE, DELETE SQL 실행하고, 바로 커밋
* 지연 로딩
  * 지연 로딩 : 객체가 실제 사용될 때 로딩
  * 즉시 로딩 : JOIN SQL로 한번에 연관된 객체까지 미리 조회


> ORM은 객체와 RDB 두 기둥 위에 있는 기술

----------------------

