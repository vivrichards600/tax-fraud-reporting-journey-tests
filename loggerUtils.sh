GREEN='\033[0;32m'
YELLOW='\033[0;33m'
RED='\033[0;31m'
NC='\033[0m'

successMsg() {
  echo -e "${GREEN}${1}${NC}"
}

errorMsg() {
  echo -e "${RED}${1}${NC}"
}

warningMsg() {
  echo -e "${YELLOW}${1}${NC}"
}