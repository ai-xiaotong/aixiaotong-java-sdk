# 安装

本SDK在java8及以上环境测试通过。

## maven仓库

在项目pom.xml中添加maven仓库：
```xml

    <repositories>
        <repository>
            <id>public</id>
            <name>public Repository</name>
            <url>http://maven.mabaoxiu.net/repository/maven-public/</url>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>
```

## maven依赖
pom.xml中添加爱小童开放平台SDK依赖：
```xml
    <dependencies>
        <dependency>
            <groupId>com.aixiaotong</groupId>
            <artifactId>aixiaotong-java-sdk</artifactId>
            <version>0.1.1-SNAPSHOT</version>
        </dependency>
    </dependencies>
```

# 调用示例

将<AK_ID>和<AK_SECRET>替换成开发者的akId和akSecret。

```java
public class FaceCompareExample {

    public static void main(String[] argv) throws AXTBaseException {
        try (
                InputStream imageAStream = new FileInputStream(new File("data/000.jpg"));
                InputStream imageBStream = new FileInputStream(new File("data/001.jpg"));
        ) {
            FaceCompareClient client = new FaceCompareClient("<AK_ID>", "<AK_SECRET>");
            FaceCompareClient.FaceCompareResponse response = client.compare(imageAStream, imageBStream);
            System.out.println("Score: " + response.getScore());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
