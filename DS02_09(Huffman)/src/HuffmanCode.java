import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class HuffmanCode {

	private Trecord frequencyTable[];
	private PriorityQueue<Trecord> pQueue;
	private int frequencyIndex;
	private boolean isLeaf;
	private int lineNumber;

	public HuffmanCode(String text) throws IOException {

		/* Frequency Table 구현 */
		initAndMakeFrequencyTable(text);

		/* FrequencyTable의 원소들을 우선순위큐에 모두 삽입 */
		addAllElementsInPriorityQueue();

		/* Huffman Tree의 합병 */
		Trecord huffmanTree = makeHuffmanTree();

		/* Encode */
		encodingTextFile(text, huffmanTree);

		/* Decode */
		decodingTextFile(huffmanTree);

	}

	private void initAndMakeFrequencyTable(String text) {

		frequencyTable = new Trecord[26];
		frequencyIndex = 0;

		for (int i = 0; i < 26; i++)
			frequencyTable[i] = new Trecord(' ');
		try {
			BufferedReader in = new BufferedReader(new FileReader(text));
			String line = in.readLine();
			while (line != null) {
				++lineNumber;
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!\"");
				while (parser.hasMoreTokens()) {
					/* word까지 대문자로 바뀌어서 나누어진 상태 */
					String word = parser.nextToken().toUpperCase();

					/* Frequency Table 구현 */
					for (int i = 0; i < word.length(); i++) {
						char temp = word.charAt(i);
						boolean found = false;

						for (int j = 0; j < 26; j++)
							if (frequencyTable[j].alphabet == temp) {
								frequencyTable[j].freq++;
								found = true;
							}
						if (!found)
							frequencyTable[frequencyIndex++] = new Trecord(word.charAt(i));
					}
				}
				line = in.readLine();
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private void addAllElementsInPriorityQueue() {
		pQueue = new PriorityQueue<Trecord>();
		for (int i = 0; i < frequencyIndex; i++)
			pQueue.add(frequencyTable[i]);
	}

	private Trecord makeHuffmanTree() {
		while (pQueue.size() != 1) {
			Trecord tNode = new Trecord();
			tNode.leftChild = pQueue.remove();
			tNode.rightChild = pQueue.remove();
			tNode.freq = tNode.leftChild.freq + tNode.rightChild.freq;
			pQueue.add(tNode);
		}
		Trecord huffmanTree = pQueue.poll();
		return huffmanTree;
	}

	private void encodingTextFile(String text, Trecord huffmanTree) throws IOException {

		FileWriter fw = new FileWriter("output.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		StringBuffer encodedText = new StringBuffer();

		lineNumber = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader(text));
			String line = in.readLine();
			while (line != null) {
				++lineNumber;
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!\"");
				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase();
					
					for (int i = 0; i < word.length(); i++) {
						char alpha = word.charAt(i);
						StringBuffer bitCode = new StringBuffer();
						
						/* 반복하는 경우에 다시 Root node로 돌리기 위해서 */
						isLeaf = false;
						
						/* encode 재귀 함수 호출 */
						bitCode = encode(huffmanTree, alpha, bitCode);
						encodedText.append(bitCode);
						bw.write(bitCode + "");
					}
				}
				bw.newLine();
				line = in.readLine();
				encodedText.append("\n");
			}
			bw.close();
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("/* Encoded text result of '" + text + ".txt' */");
		System.out.println(encodedText);
	}

	private void decodingTextFile(Trecord huffmanTree) {

		StringBuffer decodedText = new StringBuffer();
		lineNumber = 0;

		try {
			BufferedReader in = new BufferedReader(new FileReader("output.txt"));
			String line = in.readLine();
			while (line != null) {
				++lineNumber;
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!\"");
				while (parser.hasMoreTokens()) {
					String bitCode = parser.nextToken();
					decode(huffmanTree, bitCode, decodedText);
				}
				line = in.readLine();
				decodedText.append("\n");
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("/* Decoded text result of 'output.txt' */");
		System.out.println(decodedText);
	}

	private StringBuffer encode(Trecord hTree, char anAlphabet, StringBuffer bitCode) {

		/* exit case */
		if (hTree.alphabet == anAlphabet) {
			isLeaf = true;
			return bitCode;
		}

		if (hTree.leftChild != null) {
			bitCode.append("0");
			bitCode = encode(hTree.leftChild, anAlphabet, bitCode);
			if (isLeaf)
				return bitCode;
			else
				bitCode.deleteCharAt(bitCode.length() - 1);
		}

		if (hTree.rightChild != null) {
			bitCode.append("1");
			bitCode = encode(hTree.rightChild, anAlphabet, bitCode);
			if (isLeaf)
				return bitCode;
			else
				bitCode.deleteCharAt(bitCode.length() - 1);
		}
		return bitCode;
	}

	private void decode(Trecord hTree, String bitCode, StringBuffer bitBuf) {

		Trecord root = hTree;
		for (int i = 0; i <= bitCode.length(); i++) {
			if (hTree.leftChild == null && hTree.rightChild == null) {
				bitBuf.append(hTree.alphabet);
				hTree = root;
				i--;
				if (i == bitCode.length() - 1)
					break;
			} else if (bitCode.charAt(i) == '0')
				hTree = hTree.leftChild;
			else if (bitCode.charAt(i) == '1')
				hTree = hTree.rightChild;
		}
	}

	private class Trecord implements Comparable<Trecord> {

		char alphabet;
		int freq;
		Trecord leftChild;
		Trecord rightChild;

		public Trecord() {
			this.alphabet = ' ';
			this.freq = 0;
		}

		public Trecord(char anAlphabet) {
			this.alphabet = anAlphabet;
			this.freq = 1;
		}

		public String toString() {
			StringBuffer buf = new StringBuffer();
			buf.append("alpha : " + alphabet + " / freq : " + freq);
			return buf + "";
		}

		@Override
		public int compareTo(Trecord aTrecord) {
			// TODO Auto-generated method stub
			if (this.freq <= aTrecord.freq)
				return -1;
			else
				return 1;
		}
	}
}
