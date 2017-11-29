package repetition.exercises.solutions.numbers;

//https://rosettacode.org/
import java.math.BigInteger;

public class Example28 {

	public static void main(String args[]) {
		Stream hamming = makeHamming();
		System.out.print("First Twenty Hamming numbers: ");
		for (int i = 0; i < 20; i++) {
			System.out.print(hamming.value());
			System.out.print(" ");
			hamming = hamming.advance();
		}
		System.out.println();
	}

	public interface Stream {
		BigInteger value();

		Stream advance();
	}

	public static class MultStream implements Stream {
		MultStream(int mult) {
			mMult = BigInteger.valueOf(mult);
		}

		MultStream setBase(Stream s) {
			mBase = s;
			return this;
		}

		public BigInteger value() {
			return mMult.multiply(mBase.value());
		}

		public Stream advance() {
			return setBase(mBase.advance());
		}

		private final BigInteger mMult;
		private Stream mBase;
	}

	private final static class RegularStream implements Stream {
		RegularStream(Stream[] streams, BigInteger val) {
			mStreams = streams;
			mVal = val;
		}

		public BigInteger value() {
			return mVal;
		}

		public Stream advance() {
			// memoized value for the next stream instance.
			if (mAdvance != null) {
				return mAdvance;
			}

			int minidx = 0;
			BigInteger next = nextStreamValue(0);
			for (int i = 1; i < mStreams.length; i++) {
				BigInteger v = nextStreamValue(i);
				if (v.compareTo(next) < 0) {
					next = v;
					minidx = i;
				}
			}
			RegularStream ret = new RegularStream(mStreams, next);
			// memoize the value!
			mAdvance = ret;
			mStreams[minidx].advance();
			return ret;
		}

		private BigInteger nextStreamValue(int streamidx) {
			// skip past duplicates in the streams we're merging.
			BigInteger ret = mStreams[streamidx].value();
			while (ret.equals(mVal)) {
				mStreams[streamidx] = mStreams[streamidx].advance();
				ret = mStreams[streamidx].value();
			}
			return ret;
		}

		private final Stream[] mStreams;
		private final BigInteger mVal;
		private RegularStream mAdvance = null;
	}

	private final static Stream makeHamming() {
		MultStream nums[] = new MultStream[] { new MultStream(2), new MultStream(3), new MultStream(5) };
		Stream ret = new RegularStream(nums, BigInteger.ONE);
		for (int i = 0; i < nums.length; i++) {
			nums[i].setBase(ret);
		}
		return ret;
	}
}