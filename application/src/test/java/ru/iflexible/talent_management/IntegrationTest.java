package ru.iflexible.talent_management;

import io.restassured.RestAssured;
import lombok.SneakyThrows;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.server.LocalServerPort;
import ru.iflexible.talent_management.common.DatabaseTest;

import static org.assertj.db.api.Assertions.assertThat;

public class IntegrationTest extends ru.iflexible.talent_management.common.IntegrationTest implements DatabaseTest {
    private final String URL_PART = "api/update-quality-categories";

    @LocalServerPort
    private int port;

    private String getUrl() {
        return "http://localhost:" + port + "/" + URL_PART;
    }

    @Test
    @SneakyThrows
    @DisplayName("В v_client 7 клиентов, 4 из них с текущей датой, среди последних у 3х заполнены ИНН, у 4го client_abs_id и abs_code, " +
            "в tr_newclientlist 1 клиент с таким же ИНН что и у 1 из клиентов из v_client с текущей датой, " +
            "после работы программы в tr_newclientlist становится 4 клиента")
    void test1() {
        executeSqlScript("ru/iflexible/talent_management/application/talent/test_data_1.sql");

        RestAssured.given()
                .log().all()
                .when()
                .get(getUrl() + "/check-for-new-clients")
                .then()
                .log().all()
                .statusCode(200);

        Table.Order sortingOrder = Table.Order.asc("id");
        Table.Order[] sorting = {sortingOrder, sortingOrder};
        Table trNewClientList = new Table(dataSource, "user", sorting);
        Table.Order[] e = trNewClientList.getColumnsToOrder();
        assertThat(trNewClientList).row(0)
                .value("id").isEqualTo(3)
                .value("name").isEqualTo("3000333")
                .value("skill").isEqualTo(3)
                .value("is_processed").isEqualTo(1);
    }
}
