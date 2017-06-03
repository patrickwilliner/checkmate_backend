package org.williner.checkmate.data;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
public abstract class BaseDO {
    @Id @Getter @Setter
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    private Long id;

    @Getter @Setter @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Getter @Setter @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
}
