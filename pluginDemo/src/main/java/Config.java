import com.cwsya.plugin.Index;

/**
 * 配置文件
 */
public class Config implements com.cwsya.Config {
    @Override
    public Index getIndex(){
        return new org.cwsya.demo.Index();
    }
}
