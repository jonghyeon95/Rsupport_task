# 공지사항 웹 어플리케이션

----------------------------

## 개발툴

* 프레임워크 : Springboot (STS4)
* DB : mysql
* front : JSP

----------------------------

## 기능

* User 회원가입 및 로그인
* 공지사항 작성/수정/삭제/조회 (첨부파일 불가)
* 공지사항 목록 페이징

----------------------------

## 실행방법

1. [java jdk1.8 설치](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)

2. [STS툴 설치](https://spring.io/tools) 

3. [mysql5.7 설치](https://dev.mysql.com/downloads/windows/installer/5.7.html)
   > mysql설치 후 root계정 생성 후 접속하여 아래 코드 입력
```
create user '생성한유저이름'@'%' identified by '생성한패스워드';

GRANT ALL PRIVILEGES ON *.* TO '생성한유저이름'@'%';

CREATE DATABASE rsupport_task CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

use rsupport_task;
```
   
4. [mysql 한글설정](https://nesoy.github.io/articles/2017-05/mysql-UTF8) 후 Mysql 재시작

5. Springboot Notice - src/main/resources - application.yml 파일 코드수정
```
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/rsupport_task?serverTimezone=Asia/Seoul
    username: 생성한유저이름
    password: 생성한패스워드
```

6. springboot Notice프로젝트 실행

7. Mysql rsupport_task에 DB백업파일 Export
   > id : sim  / pw : 0413
   > id : user2 / pw : user2
   > id : user3 / pw : user3
