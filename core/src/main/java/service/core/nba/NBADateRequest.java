
package service.core.nba;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class NBADateRequest {

    @SerializedName("api")
    @Expose
    private NBAApi NBAApi;

    public NBAApi getNBAApi() {
        return NBAApi;
    }

    public void setNBAApi(NBAApi NBAApi) {
        this.NBAApi = NBAApi;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("NBAApi", NBAApi).toString();
    }

}
