package operator.utils;



import java.text.SimpleDateFormat;

/**
 * Created by german on 15.11.14.
 */

public class Test {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    public static void main(String[] args) {
        String JSP_POSSIBLE_OPTIONS_FOR_TARIFF = "Доступные опции для тарифа";
        String JSP_CONTRACTS_OPTION = "Опция";
        String JSP_CONTRACTS_OPTION_PRICE = "Цена";
        String JSP_CONTRACTS_OPTION_INITIAL_PRICE = "Цена подключения";
        String JSP_NO_OPTIONS_FOR_TARIFF = "К данному тарифу невозможно подключить опции.";
        String JSP_NO_OPTIONS_TOGETHER = "Для данной опции нет других обязательных к подключению опций.";
        String JSP_NO_OPTIONS_INCOMPATIBLE = "Для данной опции нет других невозможных к подключению опций.";

        System.out.println("<tr name='trow' class='ui-table-data-row ui-state-even ui-selected' onclick=getOptionsForOption('" + 2 + "', '" +
                JSP_CONTRACTS_OPTION  + "', '" + JSP_CONTRACTS_OPTION_PRICE + "', '" + JSP_CONTRACTS_OPTION_INITIAL_PRICE +
                "', '" + JSP_NO_OPTIONS_TOGETHER + "', '" + JSP_NO_OPTIONS_INCOMPATIBLE +  "')>");
        }

    }

