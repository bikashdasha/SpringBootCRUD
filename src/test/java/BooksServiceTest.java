import com.javatpoint.repository.BooksRepository;
import com.javatpoint.service.BooksService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BooksServiceTest {

    @Mock
    private BooksRepository booksRepository;

    @InjectMocks
    private BooksService booksService;

    @Test
    void testGetBookCountByAuthor_found() {

        when(booksRepository.countByAuthorIgnoreCase("martin"))
                .thenReturn(2L);

        long result = booksService.getBookCountByAuthor("martin");

        assertEquals(2L, result);
    }

    @Test
    void testGetBookCountByAuthor_notFound() {

        when(booksRepository.countByAuthorIgnoreCase("unknown"))
                .thenReturn(0L);

        long result = booksService.getBookCountByAuthor("unknown");

        assertEquals(0L, result);
    }
}
