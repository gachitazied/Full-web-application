package com.ziedgach.book.book;

import com.ziedgach.book.common.PageResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
@Tag(name = "Book")
public class BookController {
    private final BookService service;
    @PostMapping
    public ResponseEntity<Integer> saveBook(
         @Valid @RequestBody BookRequest request,
         Authentication connectedeUser
    )
    {
        return ResponseEntity.ok(service.save(request,connectedeUser));
    }

    @GetMapping("{book_id}")
    public ResponseEntity<BookResponse> findBookById(@PathVariable("book_id") Integer bookId)
    {
        return ResponseEntity.ok(service.findById(bookId));
    }


    @GetMapping
    public ResponseEntity<PageResponse<BookResponse>> findAllBooks(
          @RequestParam(name = "page" , defaultValue = "0",required = false) int page,
          @RequestParam(name = "size" , defaultValue = "10",required = false) int size,
          Authentication connectedeUser
    )
    {
        return ResponseEntity.ok(service.findAllBooks(page,size,connectedeUser));
    }

    @GetMapping("/owner")
    public ResponseEntity<PageResponse<BookResponse>> findAllBooksByOwner(
            @RequestParam(name = "page" , defaultValue = "0",required = false) int page,
            @RequestParam(name = "size" , defaultValue = "10",required = false) int size,
            Authentication connectedeUser
    )
    {
        return ResponseEntity.ok(service.findAllBooksByOwner(page,size,connectedeUser));
    }


    @GetMapping("/borrowed")
    public ResponseEntity<PageResponse<BorrowedBookResponse>> findAllBorrowedBooks(
            @RequestParam(name = "page" , defaultValue = "0",required = false) int page,
            @RequestParam(name = "size" , defaultValue = "10",required = false) int size,
            Authentication connectedeUser
    )
    {
        return ResponseEntity.ok(service.findAllBorrowedBooks(page,size,connectedeUser));
    }

    @GetMapping("/returned")
    public ResponseEntity<PageResponse<BorrowedBookResponse>> findAllReturnedBooks(
            @RequestParam(name = "page" , defaultValue = "0",required = false) int page,
            @RequestParam(name = "size" , defaultValue = "10",required = false) int size,
            Authentication connectedeUser
    )
    {
        return ResponseEntity.ok(service.findAllReturnedBooks(page,size,connectedeUser));

    }


    @PatchMapping("/shareable/{book_id}")
    public ResponseEntity<Integer> updateShareableStatus
            (
                    @PathVariable("book_id") Integer bookId,
                    Authentication connectedUser
            )
    {
        return ResponseEntity.ok(service.updateShareableStatus(bookId,connectedUser));

    }
}