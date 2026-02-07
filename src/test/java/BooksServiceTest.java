import com.javatpoint.repository.BooksRepository;
import com.javatpoint.service.BooksService;
import org.junit.jupiter.api.Test;
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
class BooksServiceTest {

    @Mock
    private BooksRepository booksRepository;

    @InjectMocks
    private BooksService booksService;

    public BooksServiceTest() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    void testBookExists_true() {

        when(booksRepository.existsById(1)).thenReturn(true);

        boolean result = booksService.isBookExists(1);

        assertTrue(result);
    }

    @Test
    void testBookExists_false() {

        when(booksRepository.existsById(99)).thenReturn(false);

        boolean result = booksService.isBookExists(99);

        assertFalse(result);
    }
}
