package exam.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.*;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Book {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "book_id")
    private Long id;
    private String bookName;
    private int price;
    private int stock;


}
