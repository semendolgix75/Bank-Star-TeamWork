package pro.sky.BankStar_TeamWork.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class RecommendationsRepository {
    private final JdbcTemplate jdbcTemplate;

    public RecommendationsRepository(@Qualifier("recommendationsJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
/*Метод queryForObject выбирает одну строку из базы данных и преобразует ее в объект,
указанный вторым аргументом в методе.
 */
    public int getRandomTransactionAmount(UUID user) {
        Integer result = jdbcTemplate.queryForObject(
                "SELECT amount FROM transactions t WHERE t.user_id = ? LIMIT 1",
                Integer.class,
                user);
        return result != null ? result : 0;
    /*    Запрос выбирает сумму транзакции пользователя по его id, так как у пользователя может быть несколько транзакций,
        а сортировка по умолчанию у H2 не определена, то данный запрос вернет нам сумму какой-то из транзакций
        — неважно какой, главное, что сумма будет одна. */
    }
}
