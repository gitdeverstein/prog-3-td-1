package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.BookEntity;
import app.prog.model.CategoryEntity;
import app.prog.repository.AuthorRepository;
import app.prog.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class BookRestMapper {
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    public BookResponse toRest(BookEntity domain) {
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(domain.getAuthor())
                .categories(domain.getCategories())
                .hasAuthor(domain.hasAuthor())
                .build();
    }

    public BookEntity toDomain(CreateBookResponse rest) {
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        return BookEntity.builder()
                .author(authorRepository.findByName(rest.getAuthor()))
                .title(rest.getTitle())
                .categories(categoryEntities)
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }

    public BookEntity toDomain(UpdateBookResponse rest) {
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        return BookEntity.builder()
                .id(rest.getId())
                .author(authorRepository.findByName(rest.getAuthor()))
                .title(rest.getTitle())
                .categories(categoryEntities)
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }
}
