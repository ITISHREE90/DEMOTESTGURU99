package utility.helper;

public enum UISelectorType {
    ID("cusId"),
    TEXT_CONTAINS("textContains"),
    TEXT("text"),
    TEXT_START_WITH("textStartWith"),
    SELECTED("selected"),
    CLASS_NAME("className"),
    XPATH("xpath"),
    VALUE("value"),
    NAME("name"),
    LINK_TEXT("linkText");

    private java.lang.String UISelectorCode;

    /**
     * init new UISelectorType
     *
     * @param s
     */
    private UISelectorType(java.lang.String s) {
        UISelectorCode = s;
    }

    /**
     * get UISelectorCode
     *
     * @return String
     */
    public java.lang.String getUISelectorCode() {
        return UISelectorCode;
    }

    /**
     * init new UISelectorType from String
     *
     * @param selectorTypeStr
     * @return UISelectorType
     */
    public static UISelectorType fromString(String selectorTypeStr) {
        if (selectorTypeStr != null) {
            for (UISelectorType b : UISelectorType.values()) {
                if (selectorTypeStr.equalsIgnoreCase(b.UISelectorCode)) {
                    return b;
                }
            }
        }
        return null;
    }
}
