package dev.kutuphane.kutuphane.api;

import dev.kutuphane.kutuphane.business.abstracts.IBookBorrowingService;
import dev.kutuphane.kutuphane.business.abstracts.IBookService;
import dev.kutuphane.kutuphane.core.config.ModelMapper.IModelMapperService;
import dev.kutuphane.kutuphane.core.result.Result;
import dev.kutuphane.kutuphane.core.result.ResultData;
import dev.kutuphane.kutuphane.core.utilies.ResultHelper;
import dev.kutuphane.kutuphane.dto.CursorResponse;
import dev.kutuphane.kutuphane.dto.request.Book.BookSaveRequest;
import dev.kutuphane.kutuphane.dto.request.BookBorrowing.BookBorrowingSaveRequest;
import dev.kutuphane.kutuphane.dto.request.BookBorrowing.BookBorrowingUpdateRequest;
import dev.kutuphane.kutuphane.dto.response.BookBorrowing.BookBorrowingResponse;
import dev.kutuphane.kutuphane.entities.Book;
import dev.kutuphane.kutuphane.entities.BookBorrowing;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/bookBorrowings")
public class BookBorrowingController {
    private final IBookBorrowingService bookBorrowingService;
    private final IModelMapperService modelMapper;
    private final IBookService bookService;

    public BookBorrowingController(IBookBorrowingService bookBorrowingService, IModelMapperService modelMapper, IBookService bookService) {
        this.bookBorrowingService = bookBorrowingService;
        this.modelMapper = modelMapper;
        this.bookService = bookService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookBorrowingResponse> save(@Valid @RequestBody BookBorrowingSaveRequest bookBorrowingSaveRequest){
        BookBorrowing saveBookBorrowing = this.modelMapper.forRequest().map(bookBorrowingSaveRequest , BookBorrowing.class);

        Book book = this.bookService.get(bookBorrowingSaveRequest.getBook_id());
        saveBookBorrowing.setBook(book);

        this.bookBorrowingService.save(saveBookBorrowing);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveBookBorrowing , BookBorrowingResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  ResultData<BookBorrowingResponse> get(@PathVariable("id") int id){
        BookBorrowing bookBorrowing = this.bookBorrowingService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(bookBorrowing,BookBorrowingResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable int id){
        this.bookBorrowingService.delete(id);
        return ResultHelper.ok();
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<BookBorrowingResponse>> cursor(
            @RequestParam(name = "page" , required = false ,defaultValue = "0") int page,
            @RequestParam(name = "pageSize" , required = false , defaultValue = "2") int pageSize
            ){
        Page<BookBorrowing> bookBorrowingPage = this.bookBorrowingService.cursor(page,pageSize);
        Page<BookBorrowingResponse> bookBorrowingResponsePage = bookBorrowingPage.map(bookBorrowing ->
                this.modelMapper.forResponse().map(bookBorrowing,BookBorrowingResponse.class));
        return ResultHelper.cursor(bookBorrowingResponsePage);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookBorrowingResponse> update(@Valid @RequestBody BookBorrowingUpdateRequest bookBorrowingUpdateRequest){
        BookBorrowing updateBookBorrowing = this.modelMapper.forRequest().map(bookBorrowingUpdateRequest,BookBorrowing.class);
        this.bookBorrowingService.save(updateBookBorrowing);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateBookBorrowing,BookBorrowingResponse.class));
    }

}


