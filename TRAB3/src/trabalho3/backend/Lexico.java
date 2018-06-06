package trabalho3.backend;

public class Lexico implements Constants
{
    private int position;
    private String input;

    public Lexico()
    {
        this("");
    }

    public Lexico(String input)
    {
        setInput(input);
    }

    public void setInput(String input)
    {
        this.input = input;
        setPosition(0);
    }

    public void setPosition(int pos)
    {
        position = pos;
    }

    public Token nextToken() throws LexicalError
    {
        if ( ! hasInput() )
            return null;

        int start = position;

        int state = 0;
        int lastState = 0;
        int endState = -1;
        int end = -1;
        String palavra= " ";        
			
        while (hasInput())
        {
            lastState = state;
            state = nextState(nextChar(), state);           
            if (state < 0)
                break;

            else
            {
                if (tokenForState(state) >= 0)
                {
                    endState = state;
                    end = position;                      
           
                }
            }
        }
        if (endState < 0 || (endState != state && tokenForState(lastState) == -2)){            
             palavra = input.substring(start, position);             
             int pos = input.indexOf(nextChar(), start +1 );
                        //necessaria essa verificação para eu poder pegar o próximo caractere
			if (pos == -1) {
			   pos = input.length();                                        
			} 
            //necessaria essa verificação pois se caso eu coloco 1. dá exceção
            if (pos + 1 <= position) {
                //necessaria essa verificação pois se caso eu coloco  R$ 47.500,0 ele pega o B    
                if (!palavra.endsWith(" ")) {
                    palavra = palavra + input.substring(pos, pos + 1).substring(0, 1);
                }
            } 
            
            throw new LexicalError(SCANNER_ERROR[lastState] +" - " +palavra);
        }
        position = end;

        int token = tokenForState(endState);

        if (token == 0)
            return nextToken();
        else
        {
            String lexeme = input.substring(start, end);
            token = lookupToken(token, lexeme);
            return new Token(token, lexeme, start);
        }
    }

    private int nextState(char c, int state)
    {
        switch (state)
        {
            case 0:
                switch (c)
                {
                    case 9: return 1;
                    case 10: return 1;
                    case 32: return 1;
                    case 48: return 2;
                    case 49: return 3;
                    case 50: return 4;
                    case 51: return 5;
                    case 52: return 5;
                    case 53: return 5;
                    case 54: return 5;
                    case 55: return 5;
                    case 56: return 5;
                    case 57: return 6;
                    case 65: return 7;
                    case 66: return 7;
                    case 67: return 7;
                    case 68: return 7;
                    case 69: return 7;
                    case 70: return 7;
                    case 71: return 7;
                    case 72: return 7;
                    case 73: return 7;
                    case 74: return 7;
                    case 75: return 7;
                    case 76: return 7;
                    case 77: return 7;
                    case 78: return 7;
                    case 79: return 7;
                    case 80: return 7;
                    case 81: return 7;
                    case 82: return 8;
                    case 83: return 7;
                    case 84: return 7;
                    case 85: return 7;
                    case 86: return 7;
                    case 87: return 7;
                    case 88: return 7;
                    case 89: return 7;
                    case 90: return 7;
                    case 193: return 9;
                    default: return -1;
                }
            case 2:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 3:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 13;
                    case 48: return 14;
                    case 49: return 14;
                    case 50: return 14;
                    case 51: return 14;
                    case 52: return 14;
                    case 53: return 14;
                    case 54: return 14;
                    case 55: return 14;
                    case 56: return 14;
                    case 57: return 15;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 4:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 13;
                    case 48: return 16;
                    case 49: return 17;
                    case 50: return 17;
                    case 51: return 17;
                    case 52: return 17;
                    case 53: return 17;
                    case 54: return 17;
                    case 55: return 17;
                    case 56: return 17;
                    case 57: return 17;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 5:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 13;
                    case 48: return 17;
                    case 49: return 17;
                    case 50: return 17;
                    case 51: return 17;
                    case 52: return 17;
                    case 53: return 17;
                    case 54: return 17;
                    case 55: return 17;
                    case 56: return 17;
                    case 57: return 17;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 6:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 13;
                    case 48: return 17;
                    case 49: return 17;
                    case 50: return 17;
                    case 51: return 18;
                    case 52: return 18;
                    case 53: return 18;
                    case 54: return 18;
                    case 55: return 18;
                    case 56: return 18;
                    case 57: return 18;
                    case 65: return 19;
                    case 66: return 19;
                    case 67: return 19;
                    case 68: return 19;
                    case 69: return 19;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 7:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 20;
                    case 49: return 21;
                    case 50: return 21;
                    case 51: return 21;
                    case 52: return 21;
                    case 53: return 21;
                    case 54: return 21;
                    case 55: return 21;
                    case 56: return 21;
                    case 57: return 21;
                    case 65: return 22;
                    case 66: return 22;
                    case 67: return 22;
                    case 68: return 22;
                    case 69: return 22;
                    case 70: return 22;
                    case 71: return 22;
                    case 72: return 22;
                    case 73: return 22;
                    case 74: return 22;
                    case 75: return 22;
                    case 76: return 22;
                    case 77: return 22;
                    case 78: return 22;
                    case 79: return 22;
                    case 80: return 22;
                    case 81: return 22;
                    case 82: return 22;
                    case 83: return 22;
                    case 84: return 22;
                    case 85: return 22;
                    case 86: return 22;
                    case 87: return 22;
                    case 88: return 22;
                    case 89: return 22;
                    case 90: return 22;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 8:
                switch (c)
                {
                    case 36: return 23;
                    case 45: return 11;
                    case 48: return 20;
                    case 49: return 21;
                    case 50: return 21;
                    case 51: return 21;
                    case 52: return 21;
                    case 53: return 21;
                    case 54: return 21;
                    case 55: return 21;
                    case 56: return 21;
                    case 57: return 21;
                    case 65: return 22;
                    case 66: return 22;
                    case 67: return 22;
                    case 68: return 22;
                    case 69: return 22;
                    case 70: return 22;
                    case 71: return 22;
                    case 72: return 22;
                    case 73: return 22;
                    case 74: return 22;
                    case 75: return 22;
                    case 76: return 22;
                    case 77: return 22;
                    case 78: return 22;
                    case 79: return 22;
                    case 80: return 22;
                    case 81: return 22;
                    case 82: return 22;
                    case 83: return 22;
                    case 84: return 22;
                    case 85: return 22;
                    case 86: return 22;
                    case 87: return 22;
                    case 88: return 22;
                    case 89: return 22;
                    case 90: return 22;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 9:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 10:
                switch (c)
                {
                    case 107: return 24;
                    default: return -1;
                }
            case 11:
                switch (c)
                {
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 12:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 13:
                switch (c)
                {
                    case 48: return 25;
                    case 49: return 25;
                    case 50: return 25;
                    case 51: return 25;
                    case 52: return 25;
                    case 53: return 25;
                    case 54: return 25;
                    case 55: return 25;
                    case 56: return 25;
                    case 57: return 25;
                    default: return -1;
                }
            case 14:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 26;
                    case 48: return 27;
                    case 49: return 27;
                    case 50: return 27;
                    case 51: return 27;
                    case 52: return 27;
                    case 53: return 27;
                    case 54: return 27;
                    case 55: return 27;
                    case 56: return 27;
                    case 57: return 27;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 15:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 26;
                    case 48: return 28;
                    case 49: return 28;
                    case 50: return 28;
                    case 51: return 28;
                    case 52: return 28;
                    case 53: return 28;
                    case 54: return 28;
                    case 55: return 28;
                    case 56: return 28;
                    case 57: return 28;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 16:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 26;
                    case 48: return 29;
                    case 49: return 30;
                    case 50: return 30;
                    case 51: return 30;
                    case 52: return 30;
                    case 53: return 30;
                    case 54: return 30;
                    case 55: return 30;
                    case 56: return 30;
                    case 57: return 30;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 17:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 26;
                    case 48: return 30;
                    case 49: return 30;
                    case 50: return 30;
                    case 51: return 30;
                    case 52: return 30;
                    case 53: return 30;
                    case 54: return 30;
                    case 55: return 30;
                    case 56: return 30;
                    case 57: return 30;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 18:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 26;
                    case 48: return 30;
                    case 49: return 30;
                    case 50: return 30;
                    case 51: return 30;
                    case 52: return 30;
                    case 53: return 30;
                    case 54: return 30;
                    case 55: return 30;
                    case 56: return 30;
                    case 57: return 30;
                    case 65: return 31;
                    case 66: return 31;
                    case 67: return 31;
                    case 68: return 31;
                    case 69: return 31;
                    case 70: return 31;
                    case 71: return 31;
                    case 72: return 31;
                    case 73: return 31;
                    case 74: return 31;
                    case 75: return 31;
                    case 76: return 31;
                    case 77: return 31;
                    case 78: return 31;
                    case 79: return 31;
                    case 80: return 31;
                    case 81: return 31;
                    case 82: return 31;
                    case 83: return 31;
                    case 84: return 31;
                    case 85: return 31;
                    case 86: return 31;
                    case 87: return 31;
                    case 88: return 31;
                    case 89: return 31;
                    case 90: return 31;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 19:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 31;
                    case 66: return 31;
                    case 67: return 31;
                    case 68: return 31;
                    case 69: return 31;
                    case 70: return 31;
                    case 71: return 31;
                    case 72: return 31;
                    case 73: return 31;
                    case 74: return 31;
                    case 75: return 31;
                    case 76: return 31;
                    case 77: return 31;
                    case 78: return 31;
                    case 79: return 31;
                    case 80: return 31;
                    case 81: return 31;
                    case 82: return 31;
                    case 83: return 31;
                    case 84: return 31;
                    case 85: return 31;
                    case 86: return 31;
                    case 87: return 31;
                    case 88: return 31;
                    case 89: return 31;
                    case 90: return 31;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 20:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 21:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 32;
                    case 66: return 32;
                    case 67: return 32;
                    case 68: return 32;
                    case 69: return 32;
                    case 70: return 32;
                    case 71: return 32;
                    case 72: return 32;
                    case 73: return 32;
                    case 74: return 32;
                    case 75: return 32;
                    case 76: return 32;
                    case 77: return 32;
                    case 78: return 32;
                    case 79: return 32;
                    case 80: return 32;
                    case 81: return 32;
                    case 82: return 32;
                    case 83: return 32;
                    case 84: return 32;
                    case 85: return 32;
                    case 86: return 32;
                    case 87: return 32;
                    case 88: return 32;
                    case 89: return 32;
                    case 90: return 32;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 22:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 33;
                    case 66: return 33;
                    case 67: return 33;
                    case 68: return 33;
                    case 69: return 33;
                    case 70: return 33;
                    case 71: return 33;
                    case 72: return 33;
                    case 73: return 33;
                    case 74: return 33;
                    case 75: return 33;
                    case 76: return 33;
                    case 77: return 33;
                    case 78: return 33;
                    case 79: return 33;
                    case 80: return 33;
                    case 81: return 33;
                    case 82: return 33;
                    case 83: return 33;
                    case 84: return 33;
                    case 85: return 33;
                    case 86: return 33;
                    case 87: return 33;
                    case 88: return 33;
                    case 89: return 33;
                    case 90: return 33;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 23:
                switch (c)
                {
                    case 32: return 34;
                    default: return -1;
                }
            case 24:
                switch (c)
                {
                    case 109: return 35;
                    default: return -1;
                }
            case 25:
                switch (c)
                {
                    case 48: return 36;
                    case 49: return 36;
                    case 50: return 36;
                    case 51: return 36;
                    case 52: return 36;
                    case 53: return 36;
                    case 54: return 36;
                    case 55: return 36;
                    case 56: return 36;
                    case 57: return 36;
                    default: return -1;
                }
            case 26:
                switch (c)
                {
                    case 48: return 37;
                    case 49: return 37;
                    case 50: return 37;
                    case 51: return 37;
                    case 52: return 37;
                    case 53: return 37;
                    case 54: return 37;
                    case 55: return 37;
                    case 56: return 37;
                    case 57: return 37;
                    default: return -1;
                }
            case 27:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 26;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 28:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 26;
                    case 48: return 38;
                    case 49: return 38;
                    case 50: return 38;
                    case 51: return 38;
                    case 52: return 38;
                    case 53: return 38;
                    case 54: return 38;
                    case 55: return 38;
                    case 56: return 38;
                    case 57: return 38;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 29:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 26;
                    case 48: return 38;
                    case 49: return 38;
                    case 50: return 38;
                    case 51: return 38;
                    case 52: return 38;
                    case 53: return 38;
                    case 54: return 38;
                    case 55: return 38;
                    case 56: return 38;
                    case 57: return 38;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 30:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 48: return 38;
                    case 49: return 38;
                    case 50: return 38;
                    case 51: return 38;
                    case 52: return 38;
                    case 53: return 38;
                    case 54: return 38;
                    case 55: return 38;
                    case 56: return 38;
                    case 57: return 38;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 31:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 20;
                    case 49: return 20;
                    case 50: return 20;
                    case 51: return 20;
                    case 52: return 20;
                    case 53: return 20;
                    case 54: return 20;
                    case 55: return 20;
                    case 56: return 20;
                    case 57: return 20;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 32:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 39;
                    case 66: return 39;
                    case 67: return 39;
                    case 68: return 39;
                    case 69: return 39;
                    case 70: return 39;
                    case 71: return 39;
                    case 72: return 39;
                    case 73: return 39;
                    case 74: return 39;
                    case 75: return 39;
                    case 76: return 39;
                    case 77: return 39;
                    case 78: return 39;
                    case 79: return 39;
                    case 80: return 39;
                    case 81: return 39;
                    case 82: return 39;
                    case 83: return 39;
                    case 84: return 39;
                    case 85: return 39;
                    case 86: return 39;
                    case 87: return 39;
                    case 88: return 39;
                    case 89: return 39;
                    case 90: return 39;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 33:
                switch (c)
                {
                    case 45: return 40;
                    case 46: return 41;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 34:
                switch (c)
                {
                    case 48: return 42;
                    case 49: return 43;
                    case 50: return 43;
                    case 51: return 43;
                    case 52: return 43;
                    case 53: return 43;
                    case 54: return 43;
                    case 55: return 43;
                    case 56: return 43;
                    case 57: return 43;
                    default: return -1;
                }
            case 36:
                switch (c)
                {
                    case 48: return 44;
                    case 49: return 44;
                    case 50: return 44;
                    case 51: return 44;
                    case 52: return 44;
                    case 53: return 44;
                    case 54: return 44;
                    case 55: return 44;
                    case 56: return 44;
                    case 57: return 44;
                    default: return -1;
                }
            case 37:
                switch (c)
                {
                    case 48: return 36;
                    case 49: return 36;
                    case 50: return 36;
                    case 51: return 36;
                    case 52: return 36;
                    case 53: return 36;
                    case 54: return 36;
                    case 55: return 36;
                    case 56: return 36;
                    case 57: return 36;
                    default: return -1;
                }
            case 38:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 39:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 45;
                    case 49: return 45;
                    case 50: return 45;
                    case 51: return 45;
                    case 52: return 45;
                    case 53: return 45;
                    case 54: return 45;
                    case 55: return 45;
                    case 56: return 45;
                    case 57: return 45;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 40:
                switch (c)
                {
                    case 48: return 46;
                    case 49: return 47;
                    case 50: return 47;
                    case 51: return 47;
                    case 52: return 47;
                    case 53: return 47;
                    case 54: return 47;
                    case 55: return 47;
                    case 56: return 47;
                    case 57: return 47;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 41:
                switch (c)
                {
                    case 48: return 48;
                    case 49: return 49;
                    case 50: return 49;
                    case 51: return 49;
                    case 52: return 49;
                    case 53: return 49;
                    case 54: return 49;
                    case 55: return 49;
                    case 56: return 49;
                    case 57: return 49;
                    default: return -1;
                }
            case 42:
                switch (c)
                {
                    case 44: return 50;
                    default: return -1;
                }
            case 43:
                switch (c)
                {
                    case 44: return 50;
                    case 46: return 51;
                    case 48: return 52;
                    case 49: return 52;
                    case 50: return 52;
                    case 51: return 52;
                    case 52: return 52;
                    case 53: return 52;
                    case 54: return 52;
                    case 55: return 52;
                    case 56: return 52;
                    case 57: return 52;
                    default: return -1;
                }
            case 44:
                switch (c)
                {
                    case 32: return 10;
                    default: return -1;
                }
            case 45:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 53;
                    case 49: return 53;
                    case 50: return 53;
                    case 51: return 53;
                    case 52: return 53;
                    case 53: return 53;
                    case 54: return 53;
                    case 55: return 53;
                    case 56: return 53;
                    case 57: return 53;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 46:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 54;
                    case 49: return 55;
                    case 50: return 55;
                    case 51: return 55;
                    case 52: return 55;
                    case 53: return 55;
                    case 54: return 55;
                    case 55: return 55;
                    case 56: return 55;
                    case 57: return 55;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 47:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 56;
                    case 49: return 57;
                    case 50: return 57;
                    case 51: return 57;
                    case 52: return 57;
                    case 53: return 57;
                    case 54: return 57;
                    case 55: return 57;
                    case 56: return 57;
                    case 57: return 57;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 48:
                switch (c)
                {
                    case 48: return 58;
                    case 49: return 59;
                    case 50: return 59;
                    case 51: return 59;
                    case 52: return 59;
                    case 53: return 59;
                    case 54: return 59;
                    case 55: return 59;
                    case 56: return 59;
                    case 57: return 59;
                    default: return -1;
                }
            case 49:
                switch (c)
                {
                    case 48: return 60;
                    case 49: return 61;
                    case 50: return 61;
                    case 51: return 61;
                    case 52: return 61;
                    case 53: return 61;
                    case 54: return 61;
                    case 55: return 61;
                    case 56: return 61;
                    case 57: return 61;
                    default: return -1;
                }
            case 50:
                switch (c)
                {
                    case 48: return 62;
                    case 49: return 62;
                    case 50: return 62;
                    case 51: return 62;
                    case 52: return 62;
                    case 53: return 62;
                    case 54: return 62;
                    case 55: return 62;
                    case 56: return 62;
                    case 57: return 62;
                    default: return -1;
                }
            case 51:
                switch (c)
                {
                    case 48: return 63;
                    case 49: return 63;
                    case 50: return 63;
                    case 51: return 63;
                    case 52: return 63;
                    case 53: return 63;
                    case 54: return 63;
                    case 55: return 63;
                    case 56: return 63;
                    case 57: return 63;
                    default: return -1;
                }
            case 52:
                switch (c)
                {
                    case 44: return 50;
                    case 46: return 51;
                    case 48: return 64;
                    case 49: return 64;
                    case 50: return 64;
                    case 51: return 64;
                    case 52: return 64;
                    case 53: return 64;
                    case 54: return 64;
                    case 55: return 64;
                    case 56: return 64;
                    case 57: return 64;
                    default: return -1;
                }
            case 53:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 65;
                    case 49: return 65;
                    case 50: return 65;
                    case 51: return 65;
                    case 52: return 65;
                    case 53: return 65;
                    case 54: return 65;
                    case 55: return 65;
                    case 56: return 65;
                    case 57: return 65;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 54:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 66;
                    case 49: return 67;
                    case 50: return 67;
                    case 51: return 67;
                    case 52: return 67;
                    case 53: return 67;
                    case 54: return 67;
                    case 55: return 67;
                    case 56: return 67;
                    case 57: return 67;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 55:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 68;
                    case 49: return 69;
                    case 50: return 69;
                    case 51: return 69;
                    case 52: return 69;
                    case 53: return 69;
                    case 54: return 69;
                    case 55: return 69;
                    case 56: return 69;
                    case 57: return 69;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 56:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 70;
                    case 49: return 71;
                    case 50: return 71;
                    case 51: return 71;
                    case 52: return 71;
                    case 53: return 71;
                    case 54: return 71;
                    case 55: return 71;
                    case 56: return 71;
                    case 57: return 71;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 57:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 72;
                    case 49: return 73;
                    case 50: return 73;
                    case 51: return 73;
                    case 52: return 73;
                    case 53: return 73;
                    case 54: return 73;
                    case 55: return 73;
                    case 56: return 73;
                    case 57: return 73;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 58:
                switch (c)
                {
                    case 48: return 74;
                    case 49: return 75;
                    case 50: return 75;
                    case 51: return 75;
                    case 52: return 75;
                    case 53: return 75;
                    case 54: return 75;
                    case 55: return 75;
                    case 56: return 75;
                    case 57: return 75;
                    default: return -1;
                }
            case 59:
                switch (c)
                {
                    case 48: return 76;
                    case 49: return 77;
                    case 50: return 77;
                    case 51: return 77;
                    case 52: return 77;
                    case 53: return 77;
                    case 54: return 77;
                    case 55: return 77;
                    case 56: return 77;
                    case 57: return 77;
                    default: return -1;
                }
            case 60:
                switch (c)
                {
                    case 48: return 78;
                    case 49: return 79;
                    case 50: return 79;
                    case 51: return 79;
                    case 52: return 79;
                    case 53: return 79;
                    case 54: return 79;
                    case 55: return 79;
                    case 56: return 79;
                    case 57: return 79;
                    default: return -1;
                }
            case 61:
                switch (c)
                {
                    case 48: return 80;
                    case 49: return 81;
                    case 50: return 81;
                    case 51: return 81;
                    case 52: return 81;
                    case 53: return 81;
                    case 54: return 81;
                    case 55: return 81;
                    case 56: return 81;
                    case 57: return 81;
                    default: return -1;
                }
            case 62:
                switch (c)
                {
                    case 48: return 82;
                    case 49: return 82;
                    case 50: return 82;
                    case 51: return 82;
                    case 52: return 82;
                    case 53: return 82;
                    case 54: return 82;
                    case 55: return 82;
                    case 56: return 82;
                    case 57: return 82;
                    default: return -1;
                }
            case 63:
                switch (c)
                {
                    case 48: return 83;
                    case 49: return 83;
                    case 50: return 83;
                    case 51: return 83;
                    case 52: return 83;
                    case 53: return 83;
                    case 54: return 83;
                    case 55: return 83;
                    case 56: return 83;
                    case 57: return 83;
                    default: return -1;
                }
            case 64:
                switch (c)
                {
                    case 44: return 50;
                    case 46: return 51;
                    default: return -1;
                }
            case 65:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 84;
                    case 49: return 84;
                    case 50: return 84;
                    case 51: return 84;
                    case 52: return 84;
                    case 53: return 84;
                    case 54: return 84;
                    case 55: return 84;
                    case 56: return 84;
                    case 57: return 84;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 66:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 85;
                    case 50: return 85;
                    case 51: return 85;
                    case 52: return 85;
                    case 53: return 85;
                    case 54: return 85;
                    case 55: return 85;
                    case 56: return 85;
                    case 57: return 85;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 67:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 85;
                    case 49: return 85;
                    case 50: return 85;
                    case 51: return 85;
                    case 52: return 85;
                    case 53: return 85;
                    case 54: return 85;
                    case 55: return 85;
                    case 56: return 85;
                    case 57: return 85;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 68:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 85;
                    case 49: return 85;
                    case 50: return 85;
                    case 51: return 85;
                    case 52: return 85;
                    case 53: return 85;
                    case 54: return 85;
                    case 55: return 85;
                    case 56: return 85;
                    case 57: return 85;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 69:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 85;
                    case 49: return 85;
                    case 50: return 85;
                    case 51: return 85;
                    case 52: return 85;
                    case 53: return 85;
                    case 54: return 85;
                    case 55: return 85;
                    case 56: return 85;
                    case 57: return 85;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 70:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 85;
                    case 49: return 85;
                    case 50: return 85;
                    case 51: return 85;
                    case 52: return 85;
                    case 53: return 85;
                    case 54: return 85;
                    case 55: return 85;
                    case 56: return 85;
                    case 57: return 85;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 71:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 85;
                    case 49: return 85;
                    case 50: return 85;
                    case 51: return 85;
                    case 52: return 85;
                    case 53: return 85;
                    case 54: return 85;
                    case 55: return 85;
                    case 56: return 85;
                    case 57: return 85;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 72:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 85;
                    case 49: return 85;
                    case 50: return 85;
                    case 51: return 85;
                    case 52: return 85;
                    case 53: return 85;
                    case 54: return 85;
                    case 55: return 85;
                    case 56: return 85;
                    case 57: return 85;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 73:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 85;
                    case 49: return 85;
                    case 50: return 85;
                    case 51: return 85;
                    case 52: return 85;
                    case 53: return 85;
                    case 54: return 85;
                    case 55: return 85;
                    case 56: return 85;
                    case 57: return 85;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 74:
                switch (c)
                {
                    case 49: return 86;
                    case 50: return 86;
                    case 51: return 86;
                    case 52: return 86;
                    case 53: return 86;
                    case 54: return 86;
                    case 55: return 86;
                    case 56: return 86;
                    case 57: return 86;
                    default: return -1;
                }
            case 75:
                switch (c)
                {
                    case 48: return 86;
                    case 49: return 86;
                    case 50: return 86;
                    case 51: return 86;
                    case 52: return 86;
                    case 53: return 86;
                    case 54: return 86;
                    case 55: return 86;
                    case 56: return 86;
                    case 57: return 86;
                    default: return -1;
                }
            case 76:
                switch (c)
                {
                    case 48: return 86;
                    case 49: return 86;
                    case 50: return 86;
                    case 51: return 86;
                    case 52: return 86;
                    case 53: return 86;
                    case 54: return 86;
                    case 55: return 86;
                    case 56: return 86;
                    case 57: return 86;
                    default: return -1;
                }
            case 77:
                switch (c)
                {
                    case 48: return 86;
                    case 49: return 86;
                    case 50: return 86;
                    case 51: return 86;
                    case 52: return 86;
                    case 53: return 86;
                    case 54: return 86;
                    case 55: return 86;
                    case 56: return 86;
                    case 57: return 86;
                    default: return -1;
                }
            case 78:
                switch (c)
                {
                    case 48: return 86;
                    case 49: return 86;
                    case 50: return 86;
                    case 51: return 86;
                    case 52: return 86;
                    case 53: return 86;
                    case 54: return 86;
                    case 55: return 86;
                    case 56: return 86;
                    case 57: return 86;
                    default: return -1;
                }
            case 79:
                switch (c)
                {
                    case 48: return 86;
                    case 49: return 86;
                    case 50: return 86;
                    case 51: return 86;
                    case 52: return 86;
                    case 53: return 86;
                    case 54: return 86;
                    case 55: return 86;
                    case 56: return 86;
                    case 57: return 86;
                    default: return -1;
                }
            case 80:
                switch (c)
                {
                    case 48: return 86;
                    case 49: return 86;
                    case 50: return 86;
                    case 51: return 86;
                    case 52: return 86;
                    case 53: return 86;
                    case 54: return 86;
                    case 55: return 86;
                    case 56: return 86;
                    case 57: return 86;
                    default: return -1;
                }
            case 81:
                switch (c)
                {
                    case 48: return 86;
                    case 49: return 86;
                    case 50: return 86;
                    case 51: return 86;
                    case 52: return 86;
                    case 53: return 86;
                    case 54: return 86;
                    case 55: return 86;
                    case 56: return 86;
                    case 57: return 86;
                    default: return -1;
                }
            case 83:
                switch (c)
                {
                    case 48: return 42;
                    case 49: return 42;
                    case 50: return 42;
                    case 51: return 42;
                    case 52: return 42;
                    case 53: return 42;
                    case 54: return 42;
                    case 55: return 42;
                    case 56: return 42;
                    case 57: return 42;
                    default: return -1;
                }
            case 84:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 87;
                    case 49: return 87;
                    case 50: return 87;
                    case 51: return 87;
                    case 52: return 87;
                    case 53: return 87;
                    case 54: return 87;
                    case 55: return 87;
                    case 56: return 87;
                    case 57: return 87;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 85:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 87:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 20;
                    case 49: return 20;
                    case 50: return 20;
                    case 51: return 20;
                    case 52: return 20;
                    case 53: return 20;
                    case 54: return 20;
                    case 55: return 20;
                    case 56: return 20;
                    case 57: return 20;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            default: return -1;
        }
    }

    private int tokenForState(int state)
    {
        if (state < 0 || state >= TOKEN_STATE.length)
            return -1;

        return TOKEN_STATE[state];
    }

    public int lookupToken(int base, String key)
    {
        int start = SPECIAL_CASES_INDEXES[base];
        int end   = SPECIAL_CASES_INDEXES[base+1]-1;

        while (start <= end)
        {
            int half = (start+end)/2;
            int comp = SPECIAL_CASES_KEYS[half].compareTo(key);

            if (comp == 0)
                return SPECIAL_CASES_VALUES[half];
            else if (comp < 0)
                start = half+1;
            else  //(comp > 0)
                end = half-1;
        }

        return base;
    }

    private boolean hasInput()
    {
        return position < input.length();
    }

    private char nextChar()
    {
        if (hasInput())
            return input.charAt(position++);
        else
            return (char) -1;
    }
}
