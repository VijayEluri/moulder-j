package jawher.moulder.moulds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jawher.moulder.ElementAndData;
import jawher.moulder.Moulder;
import jawher.moulder.MoulderUtils;
import jawher.moulder.NodeAndData;
import jawher.moulder.Value;
import jawher.moulder.values.SimpleValue;

/**
 * A moulder that removes its input element from the resuling document
 * 
 * @author jawher
 * 
 */
public class Remover implements Moulder {
	private Value<Boolean> remove;

	/**
	 * Creates a remover that removes its input element from the resulting
	 * document
	 */
	public Remover() {
		this(new SimpleValue<Boolean>(true));
	}

	/**
	 * Creates a remover that conditionally removes its input element from the
	 * resulting document
	 * 
	 * @param remove
	 *            a value that returns a boolean indicating if the input element
	 *            is to be removed or not from the resulting document
	 */
	public Remover(Value<Boolean> remove) {
		super();
		this.remove = remove;
	}

	public List<NodeAndData> process(ElementAndData nd, MoulderUtils f) {
		remove.bind(nd);
		if (remove.get()) {
			return Collections.EMPTY_LIST;
		} else {
			List<NodeAndData> res = new ArrayList<NodeAndData>();
			res.add(nd.toNodeAndData());
			return res;
		}
	}

}
