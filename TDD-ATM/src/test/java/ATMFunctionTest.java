import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class ATMFunctionTest {

  @InjectMocks
    private ATMFunction atmFunction;
  @Mock
    private Bank bank;
  @BeforeEach
    void setup(){
      bank = mock(Bank.class);
      atmFunction = new ATMFunction(bank);
  }
  @Test
    void checkPin(){
      when(bank.getPinCode()).thenReturn(999);
      when(bank.getPinAttempts()).thenReturn(0);
      int expected = 999;
      int actual = atmFunction.pinCheck(bank);
      assertEquals(expected, actual);
  }
  @Test
    void checkIfCardIsFrozen(){
      when(bank.isCardAvailable()).thenReturn(false);
      boolean expected = false;
      boolean actual = atmFunction.cardStatus(bank);
  }
  @Test
    void withdrawTooMuchBalance(){
      when(bank.getBalance()).thenReturn(1);
      boolean expected = false;
      boolean actual = atmFunction.withdrawAccepted(bank);
      System.out.println(atmFunction.withdrawAccepted(bank));
      assertEquals(expected, actual);
  }
  @Test
    void depositMoneyTest(){
      int getCurrencyReturn = 500;
      when(bank.getBalance()).thenReturn(getCurrencyReturn);
      when(bank.depositMoney(20, bank.getBalance())).thenReturn(520);
      int expected = 520;
      int actual = atmFunction.depositMoney(bank);
      assertEquals(expected, actual);
      verify(bank).depositMoney(anyInt(), anyInt());
  }
  @Test
    void withdrawMoneyTest(){
      int getCurrency = 500;
      when(bank.getBalance()).thenReturn(getCurrency);
      when(bank.withdrawMoney(10, bank.getBalance())).thenReturn(490);
      int expected = 490;
      int actual = atmFunction.withdrawMoney(bank);
      assertEquals(expected, actual);
      verify(bank).withdrawMoney(anyInt(), anyInt());
  }
  @Test
    void checkBalanceTest(){
      when(bank.getBalance()).thenReturn(40);
      int expected = 40;
      int actual = atmFunction.checkBalance(bank);
      System.out.println(atmFunction.checkBalance(bank));
      assertEquals(expected, actual);
  }
  @Test
    void killProcess(){
      boolean expected = true;
      boolean actual = atmFunction.closeATM();
      System.out.println(atmFunction.closeATM());
      assertEquals(expected, actual);
  }

  @Test
    void bankTestFinal(){
      try {
          MockedStatic<Bank> mockedStaticConverter = mockStatic(Bank.class);
          mockedStaticConverter.when(() -> bank.bankName()).thenReturn("Nordea");

          String expected = "Nordea";
          String actual = bank.bankName();
          assertEquals(expected, actual);
          System.out.println(bank.bankName());
      }catch (Exception e){
          e.printStackTrace();
      }
  }

}