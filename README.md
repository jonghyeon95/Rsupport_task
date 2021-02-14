#공지사항 웹 어플리케이션 ##Rsupport 면접과제

----------------------------

실행방법

1.[java jdk1.8 설치](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)

2.[mysql5.7 설치](https://dev.mysql.com/downloads/windows/installer/5.7.html)
   > mysql설치 후 root계정 생성 후 접속하여 아래 코드 입력
   ```
   -- 유저이름@
create user '생성한유저이름'@'%' identified by '생성한패스워드';

GRANT ALL PRIVILEGES ON *.* TO '생성한유저이름'@'%';

CREATE DATABASE rsupport_task CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

use rsupport_task;
   ```
   
   >[mysql 한글설정] (https://nesoy.github.io/articles/2017-05/mysql-UTF8) 후 Mysql 재시작
   
   
  
   
