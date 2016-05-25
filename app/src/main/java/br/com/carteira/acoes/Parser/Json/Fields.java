package br.com.carteira.acoes.Parser.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lucas.coelho.dutra on 24/05/2016.
 */
public class Fields {
    @SerializedName("change")
    @Expose
    private String change;
    @SerializedName("chg_percent")
    @Expose
    private String chgPercent;
    @SerializedName("day_high")
    @Expose
    private String dayHigh;
    @SerializedName("day_low")
    @Expose
    private String dayLow;
    @SerializedName("issuer_name")
    @Expose
    private String issuerName;
    @SerializedName("issuer_name_lang")
    @Expose
    private String issuerNameLang;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("ts")
    @Expose
    private String ts;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("utctime")
    @Expose
    private String utctime;
    @SerializedName("volume")
    @Expose
    private String volume;
    @SerializedName("year_high")
    @Expose
    private String yearHigh;
    @SerializedName("year_low")
    @Expose
    private String yearLow;

    /**
     *
     * @return
     *     The change
     */
    public String getChange() {
        return change;
    }

    /**
     *
     * @param change
     *     The change
     */
    public void setChange(String change) {
        this.change = change;
    }

    /**
     *
     * @return
     *     The chgPercent
     */
    public String getChgPercent() {
        return chgPercent;
    }

    /**
     *
     * @param chgPercent
     *     The chg_percent
     */
    public void setChgPercent(String chgPercent) {
        this.chgPercent = chgPercent;
    }

    /**
     *
     * @return
     *     The dayHigh
     */
    public String getDayHigh() {
        return dayHigh;
    }

    /**
     *
     * @param dayHigh
     *     The day_high
     */
    public void setDayHigh(String dayHigh) {
        this.dayHigh = dayHigh;
    }

    /**
     *
     * @return
     *     The dayLow
     */
    public String getDayLow() {
        return dayLow;
    }

    /**
     *
     * @param dayLow
     *     The day_low
     */
    public void setDayLow(String dayLow) {
        this.dayLow = dayLow;
    }

    /**
     *
     * @return
     *     The issuerName
     */
    public String getIssuerName() {
        return issuerName;
    }

    /**
     *
     * @param issuerName
     *     The issuer_name
     */
    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    /**
     *
     * @return
     *     The issuerNameLang
     */
    public String getIssuerNameLang() {
        return issuerNameLang;
    }

    /**
     *
     * @param issuerNameLang
     *     The issuer_name_lang
     */
    public void setIssuerNameLang(String issuerNameLang) {
        this.issuerNameLang = issuerNameLang;
    }

    /**
     *
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     *     The price
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @param price
     *     The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     *
     * @return
     *     The symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     *
     * @param symbol
     *     The symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     *
     * @return
     *     The ts
     */
    public String getTs() {
        return ts;
    }

    /**
     *
     * @param ts
     *     The ts
     */
    public void setTs(String ts) {
        this.ts = ts;
    }

    /**
     *
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     *     The utctime
     */
    public String getUtctime() {
        return utctime;
    }

    /**
     *
     * @param utctime
     *     The utctime
     */
    public void setUtctime(String utctime) {
        this.utctime = utctime;
    }

    /**
     *
     * @return
     *     The volume
     */
    public String getVolume() {
        return volume;
    }

    /**
     *
     * @param volume
     *     The volume
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     *
     * @return
     *     The yearHigh
     */
    public String getYearHigh() {
        return yearHigh;
    }

    /**
     *
     * @param yearHigh
     *     The year_high
     */
    public void setYearHigh(String yearHigh) {
        this.yearHigh = yearHigh;
    }

    /**
     *
     * @return
     *     The yearLow
     */
    public String getYearLow() {
        return yearLow;
    }

    /**
     *
     * @param yearLow
     *     The year_low
     */
    public void setYearLow(String yearLow) {
        this.yearLow = yearLow;
    }
}
