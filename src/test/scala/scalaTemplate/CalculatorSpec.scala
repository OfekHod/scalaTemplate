package scalaTemplate

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSpec, Matchers}
import scalaTemplate.math.Calculator
import scalaTemplate.settings.CalculatorSettings

class CalculatorSpec extends FunSpec with Matchers with GeneratorDrivenPropertyChecks {
  val settings = CalculatorSettings(
    n3 = 0,
    minRes = 0,
    maxRes = 10)

  describe("Calc") {
    it("sum function returns minSum when sum is under it") {
      val minSum = 0
      val maxSum = 10
      forAll { (n1: Int, n2: Int) =>
        whenever(n1 + n2 <= maxSum) {
          if (n1 + n2 >= minSum) {
            Calculator.sum(n1, n2, settings) shouldBe (n1 + n2)
          } else {
            Calculator.sum(n1, n2, settings) shouldBe minSum
          }
        }
      }
    }

    it("sum function returns maxSum when sum is above it") {
      val minSum = 0
      val maxSum = 10
      forAll { (n1: Int, n2: Int) =>
        whenever(n1 + n2 >= minSum) {
          if (n1 + n2 <= maxSum) {
            Calculator.sum(n1, n2, settings) shouldBe (n1 + n2)
          } else {
            Calculator.sum(n1, n2, settings) shouldBe maxSum
          }
        }
      }
    }
  }
}
