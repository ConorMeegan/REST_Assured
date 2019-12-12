
package service.nba;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class DateRequest {

    @SerializedName("api")
    @Expose
    private Api api;

    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = api;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("api", api).toString();
    }

}
