
public class tipsForPrograming {
	
	
/** 这题难点的确是自己写出YahtzeeMagicStub.checkCategory这个方法，我个人的思想是：
  * 5个dice相减，共有10个结果，储存在一个一维数组里面
  * 结果全部=0， AAAAA类型，符合： yahtzee / four of a kind / three of a kind
  * 6次 =0， AAAAB类型，符合：four of a kind / three of a kind
  * 4次 =0， AAABB类型， 符合： full house / three of a kind
  * 3次 =0， AAABC类型，符合： three of a kind
  * 而9,8,7,5,2,1,0不需要考虑。

  * 以上涵盖了 所有的 three of a kind, four of a kind, full house, yahtzee类型

  * 下面只剩 small straight和large straight, 因为种类比较少，不需要排序可以直接列举出来

  * small straight一定需要有，1234， 或者 2345， 或者 3456
  * large straight一定需要有，12345 或者 23456 

  * 这样写方法应该就可以了。
  */
	
	
}