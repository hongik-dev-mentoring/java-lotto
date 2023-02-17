// package domain;
//
// import static org.assertj.core.api.Assertions.*;
//
// import java.util.List;
// import java.util.stream.Collectors;
//
// import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.Test;
//
// class RandomNumberPickerTest {
//
// 	@Test
// 	void 범위내의_숫자를_뽑을수_있다() {
// 		RandomNumberPicker randomNumberPicker = new RandomNumberPicker(from, to, number);
//
// 		Numbers numbers = randomNumberPicker.pickNumber();
// 		List<Integer> actualNumbers = numbers.getNumbers();
// 		List<Integer> expectedNumbers = List.copyOf(actualNumbers);
// 		List<Integer> afterFilteringNumbers = actualNumbers.stream()
// 			.filter(i -> i < to)
// 			.filter(i -> i >= from)
// 			.collect(Collectors.toList());
//
//
// 		assertThat(afterFilteringNumbers).isEqualTo(expectedNumbers);
// 	}
//
//
// }
