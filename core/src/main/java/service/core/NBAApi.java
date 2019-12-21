
package service.core;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class NBAApi {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("results")
    @Expose
    private Integer results;
    @SerializedName("filters")
    @Expose
    private List<String> filters = null;
    @SerializedName("NBAGames")
    @Expose
    private List<NBAGame> NBAGames = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

    public List<NBAGame> getNBAGames() {
        return NBAGames;
    }

    public void setNBAGames(List<NBAGame> NBAGames) {
        this.NBAGames = NBAGames;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("status", status).append("message", message).append("results", results).append("filters", filters).append("NBAGames", NBAGames).toString();
    }

}
