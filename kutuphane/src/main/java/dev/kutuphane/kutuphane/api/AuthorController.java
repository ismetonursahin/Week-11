package dev.kutuphane.kutuphane.api;

import dev.kutuphane.kutuphane.business.abstracts.IAuthorService;
import dev.kutuphane.kutuphane.core.config.ModelMapper.IModelMapperService;
import dev.kutuphane.kutuphane.core.result.Result;
import dev.kutuphane.kutuphane.core.result.ResultData;
import dev.kutuphane.kutuphane.core.utilies.ResultHelper;
import dev.kutuphane.kutuphane.dto.CursorResponse;
import dev.kutuphane.kutuphane.dto.request.Author.AuthorSaveRequest;
import dev.kutuphane.kutuphane.dto.request.Author.AuthorUpdateRequest;
import dev.kutuphane.kutuphane.dto.response.Author.AuthorResponse;
import dev.kutuphane.kutuphane.entities.Author;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Currency;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {

    @Autowired
    private final IAuthorService authorService;
    private final IModelMapperService modelMapper;


    public AuthorController(IAuthorService authorService, IModelMapperService modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AuthorResponse> save(@Valid @RequestBody AuthorSaveRequest authorSaveRequest) {
        Author saveAuthor = this.modelMapper.forRequest().map(authorSaveRequest, Author.class);
        this.authorService.save(saveAuthor);
        // id ve name i donduren     ->
        return ResultHelper.created(this.modelMapper.forResponse().map(saveAuthor, AuthorResponse.class));
        // response yapısı oluştu.

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> get(@PathVariable("id") int id) {
        Author author = this.authorService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(author, AuthorResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.authorService.delete(id);
        return ResultHelper.ok();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> update(@Valid @RequestBody AuthorUpdateRequest authorUpdateRequest) {
        Author updateAuthor = this.modelMapper.forRequest().map(authorUpdateRequest, Author.class);
        this.authorService.update(updateAuthor);

        return ResultHelper.success(this.modelMapper.forResponse().map(updateAuthor, AuthorResponse.class));

    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<AuthorResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "2") int pageSize
    ) {
        Page<Author> authorPage = this.authorService.cursor(page,pageSize);
        Page<AuthorResponse> authorResponsePage = authorPage.map(author ->
                this.modelMapper.forResponse().map(author , AuthorResponse.class));
            return ResultHelper.cursor(authorResponsePage);
    }


}
