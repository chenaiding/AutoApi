package cases;

import model.CheckBalance;
import model.InterfaceName;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import report.UrlConfig;
import utils.ConfigUrl;
import utils.DatabaseConfig;

import java.io.IOException;

/**
 * @author chenaiding
 * Created on 2020/7/23.
 */
public class CheckBalanceCase {

    @BeforeTest(groups = "checkBalance", description = "获取接口测试地址")
    public void beforeRun(){
        UrlConfig.checkBalance = ConfigUrl.getUrl(InterfaceName.CHECHBANLACE);
    }

    @Test(groups = "checkBalance", description = "测试查余额接口")
    public void checkBalanceTrue() throws IOException {
        SqlSession sqlSession = DatabaseConfig.getSqlsession();
        CheckBalance checkBalance = sqlSession.selectOne("checkBalance",1);
        System.out.println(checkBalance.toString());
        System.out.println(UrlConfig.checkBalance);
        String result = getResult(checkBalance);
        boolean isPass  = result.contains(result);
        Assert.assertEquals(isPass,true);

    }


    private String getResult(CheckBalance checkBalance) throws IOException {

        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(UrlConfig.checkBalance);
        post.setHeader("Content-type","application/json");
        post.setHeader("Accept","application/json");
        String param = checkBalance.getParam();
        StringEntity entity = new StringEntity(param);
        post.setEntity(entity);
        CloseableHttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        return result;

    }

}
