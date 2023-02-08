db details for local:

spring.datasource.url = jdbc:mysql://localhost:3306/quickdb?allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username = root
spring.datasource.password = root123

## Hibernate Properties
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update

allowPublicKeyRetrieval=true

# JWT PROPS
app.jwtSecret=JWTSuperSecretKeyHMS
app.jwtExpirationInMs=604800000
spring.main.allow-bean-definition-overriding=true

